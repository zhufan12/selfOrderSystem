package com.morgen.order.entity;


import com.morgen.order.enums.OrderStatus;
import com.morgen.order.enums.PayStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order_master")
@EntityListeners(AuditingEntityListener.class)
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String buyerName;
    @Column
    private String buyerPhone;
    @Column
    private String buyerAddress;
    @Column
    private String buyerUuid;
    @Column
    private BigDecimal amount;
    @Column
    @Enumerated
    private OrderStatus status = OrderStatus.NEW;
    @Column
    @Enumerated
    private PayStatus payStatus = PayStatus.WAIT;

    @Column
    @CreationTimestamp
    private Date createTime;

    @Column
    @UpdateTimestamp
    private Date updateTime;

}
