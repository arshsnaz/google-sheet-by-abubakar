package com.example.zeotap1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cells")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cell {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "row_index")
    private int rowIndex;

    @Column(name = "col_index")
    private int colIndex;

    @Column(name = "content")
    private String content;

    @Column(name = "sheet_name")
    private String sheetName;
}
