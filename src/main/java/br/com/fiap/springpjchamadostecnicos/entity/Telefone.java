package br.com.fiap.springpjchamadostecnicos.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


@Entity
@Table(name = "TB_TELEFONE")
public class Telefone {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
    @SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", allocationSize = 1)
    @Column(name = "ID_TELEFONE")
    private Long id;


    private String ddi;
    private String ddd;
    private String numero;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "SOLICITANTE",
            referencedColumnName = "ID_SOLICITANTE",
            foreignKey = @ForeignKey(
                    name = "FK_TELEFONE_SOLICITANTE"
            )
    )
    private Solicitante solicitante;

}
