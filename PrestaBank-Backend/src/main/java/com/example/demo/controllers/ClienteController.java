package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ClienteEntity;
import com.example.demo.services.ClienteService;

@RestController
@RequestMapping("/api/v1/cliente")
@CrossOrigin("*")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<ClienteEntity> nuevoCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity nuevoCliente = clienteService.guardaCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    @PutMapping("/")
    public ResponseEntity<ClienteEntity> actualizaCliente(@RequestBody ClienteEntity cliente) {
        ClienteEntity clienteActualizado = clienteService.actualizaCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClienteEntity>> listaClientes() {
        List<ClienteEntity> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        List<ClienteEntity> clientes = clienteService.getClientes();
        if (clientes.isEmpty()) {
            return ResponseEntity.ok("Aucun client trouvé.");
        } else {
            return ResponseEntity.ok("Clients trouvés : " + clientes.size());
        }
    }

    @GetMapping("/simple")
    public ResponseEntity<String> simple() {
        return ResponseEntity.ok("Endpoint simple fonctionne !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteEntity> getClienteById(@PathVariable Long id) {
        ClienteEntity cliente = clienteService.getClienteById(id);
        return ResponseEntity.ok(cliente);
    }

    @GetMapping("/rut/{rut}")
    public ResponseEntity<ClienteEntity> getClienteByRut(@PathVariable String rut) {
        ClienteEntity cliente = clienteService.getClienteByRut(rut);
        return ResponseEntity.ok(cliente);
    }
}
