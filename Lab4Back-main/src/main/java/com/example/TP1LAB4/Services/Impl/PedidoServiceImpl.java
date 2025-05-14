package com.example.TP1LAB4.Services.Impl;

import com.example.TP1LAB4.Entities.Instrumento;
import com.example.TP1LAB4.Entities.Pedido;
import com.example.TP1LAB4.Repositories.BaseRepository;
import com.example.TP1LAB4.Repositories.PedidoRepository;
import com.example.TP1LAB4.Services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoServiceImpl(BaseRepository<Pedido, Long> baseRepository, PedidoRepository pedidoRepository) {
        super(baseRepository);
        this.pedidoRepository = pedidoRepository;
    }


    @Override
    public List<Pedido> findAll() throws Exception {
        try {
            List<Pedido> entities = baseRepository.findAll();
            return entities;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<Pedido> findByFechaBetween(LocalDate fechaDesde, LocalDate fechaHasta) {
        return pedidoRepository.findByFechaBetween(fechaDesde, fechaHasta);
    }
}
