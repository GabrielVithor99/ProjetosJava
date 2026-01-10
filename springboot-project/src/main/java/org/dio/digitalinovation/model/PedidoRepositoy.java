package org.dio.digitalinovation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepositoy extends JpaRepository<Pedido,Long> {
}
