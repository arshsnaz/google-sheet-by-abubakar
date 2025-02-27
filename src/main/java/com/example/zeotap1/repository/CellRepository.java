package com.example.zeotap1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.zeotap1.model.Cell;

@Repository
public interface CellRepository extends JpaRepository<Cell, Long> {

    List<Cell> findBySheetName(String sheetName);

    @Query("SELECT c FROM Cell c WHERE c.sheetName = :sheetName AND CONCAT(CHAR(65 + c.colIndex), c.rowIndex + 1) BETWEEN :start AND :end")
    List<Cell> findCellsInRange(String start, String end);

    @Query("SELECT c FROM Cell c WHERE c.sheetName = :sheetName AND CONCAT(CHAR(65 + c.colIndex), c.rowIndex + 1) = :cellRef")
    Cell findByCellReference(String cellRef);
}
