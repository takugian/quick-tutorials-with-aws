package com.awsquickstarts.gameapi.model.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class GameTo {

    private Long id;

    private String name;

    private String platform;

    private String company;

    private String developer;

}
