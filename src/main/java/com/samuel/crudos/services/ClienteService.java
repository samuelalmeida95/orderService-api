package com.samuel.crudos.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import com.samuel.crudos.DTOS.ClienteDTO;
import com.samuel.crudos.model.Cliente;
import com.samuel.crudos.model.Pessoa;
import com.samuel.crudos.repositories.ClienteRepository;
import com.samuel.crudos.repositories.PessoaRepository;
import com.samuel.crudos.services.exceptions.DataIntegratyViolationException;
import com.samuel.crudos.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public PessoaRepository pessoaRepository;

    public Cliente findById(Integer idCliente) {
        Optional<Cliente> clienteBuscado = clienteRepository.findById(idCliente);
        return clienteBuscado.orElseThrow(() -> new ObjectNotFoundException(
                "Cliente não encontrado id: " + idCliente + ", Tipo: " + Cliente.class.getName()));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente create(ClienteDTO objDTO) {
        if (findByCPF(objDTO) != null)
            throw new DataIntegratyViolationException("CPF já cadastrado na base de dados CPF: " + objDTO.getCpf());

        return clienteRepository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
    }

    public Cliente update(Integer idCliente, @Valid ClienteDTO clienteDTO) {
        Cliente clienteBuscado = findById(idCliente);

        if (findByCPF(clienteDTO) != null && findByCPF(clienteDTO).getId() != idCliente) {
            throw new DataIntegratyViolationException("CPF já cadstrado na base de dados");
        }

        clienteBuscado = updateData(clienteBuscado, clienteDTO);
        return clienteRepository.save(clienteBuscado);
    }

    public Cliente updateData(Cliente clienteParaAtualizar, ClienteDTO cliente) {
        clienteParaAtualizar.setNome(cliente.getNome());
        clienteParaAtualizar.setCpf(cliente.getCpf());
        clienteParaAtualizar.setTelefone(cliente.getTelefone());
        return clienteParaAtualizar;
    }

    private Pessoa findByCPF(ClienteDTO objDTO) {
        Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
        if (obj != null)
            return obj;
        return null;
    }

    public void delete(Integer idCliente) {
        findById(idCliente);
        try {
            clienteRepository.deleteById(idCliente);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegratyViolationException("Cliente não pode ser deletado, possui OS associadas");
        }
    }
}