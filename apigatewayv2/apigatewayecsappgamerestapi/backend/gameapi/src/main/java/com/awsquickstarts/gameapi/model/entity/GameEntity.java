package com.awsquickstarts.gameapi.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TB_GAME")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class GameEntity {

    @Id
    @GeneratedValue
    @Column(name = "GAME_ID", nullable = false)
    private Long id;

    @Column(name = "GAME_NAME", nullable = false)
    private String name;

    @Column(name = "GAME_PLATFORM_NAME", nullable = false)
    private String platform;

    @Column(name = "GAME_COMPANY_NAME", nullable = false)
    private String company;

    @Column(name = "GAME_DEVELOPER_NAME", nullable = false)
    private String developer;

}
