package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor@AllArgsConstructor
@Table(name = "contoh")
public class ContohEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String namaFile;
    private String tipeDataFile;
    private byte[] data;
}
