package com.example.zeotap1.service;

import com.example.zeotap1.model.Cell;
import com.example.zeotap1.repository.CellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CellService {

    @Autowired
    private CellRepository cellRepository;

    // Save or update cell data
    public Cell saveOrUpdateCell(Cell cell) {
        return cellRepository.save(cell);
    }

    // Get all cells in a sheet
    public List<Cell> getCellsBySheetName(String sheetName) {
        return cellRepository.findBySheetName(sheetName);
    }

    // Get a specific cell by ID
    public Optional<Cell> getCellById(Long id) {
        return cellRepository.findById(id);
    }

    // Delete a cell by ID
    public void deleteCell(Long id) {
        cellRepository.deleteById(id);
    }

    // Evaluate Formulas
    public String evaluateFormula(String formula) {
        try {
            if (formula.startsWith("=SUM(")) {
                return String.valueOf(sumFormula(formula));
            }
            if (formula.startsWith("=AVERAGE(")) {
                return String.valueOf(averageFormula(formula));
            }
            if (formula.startsWith("=MIN(")) {
                return String.valueOf(minFormula(formula));
            }
            if (formula.startsWith("=MAX(")) {
                return String.valueOf(maxFormula(formula));
            }
            if (formula.startsWith("=COUNT(")) {
                return String.valueOf(countFormula(formula));
            }
            if (formula.startsWith("=TRIM(")) {
                return trimFormula(formula);
            }
            if (formula.startsWith("=UPPER(")) {
                return upperFormula(formula);
            }
            if (formula.startsWith("=LOWER(")) {
                return lowerFormula(formula);
            }
        } catch (Exception e) {
            return "Error!";
        }
        return "Invalid Formula";
    }

    private double sumFormula(String formula) {
        List<Cell> cells = extractCells(formula);
        return cells.stream().mapToDouble(c -> Double.parseDouble(c.getContent())).sum();
    }

    private double averageFormula(String formula) {
        List<Cell> cells = extractCells(formula);
        return cells.stream().mapToDouble(c -> Double.parseDouble(c.getContent())).average().orElse(0);
    }

    private double minFormula(String formula) {
        List<Cell> cells = extractCells(formula);
        return cells.stream().mapToDouble(c -> Double.parseDouble(c.getContent())).min().orElse(0);
    }

    private double maxFormula(String formula) {
        List<Cell> cells = extractCells(formula);
        return cells.stream().mapToDouble(c -> Double.parseDouble(c.getContent())).max().orElse(0);
    }

    private long countFormula(String formula) {
        List<Cell> cells = extractCells(formula);
        return cells.stream().count();
    }

    private String trimFormula(String formula) {
        return extractSingleCell(formula).trim();
    }

    private String upperFormula(String formula) {
        return extractSingleCell(formula).toUpperCase();
    }

    private String lowerFormula(String formula) {
        return extractSingleCell(formula).toLowerCase();
    }

    private List<Cell> extractCells(String formula) {
        String range = formula.substring(formula.indexOf("(") + 1, formula.indexOf(")"));
        String[] cellRange = range.split(":");
        return cellRepository.findCellsInRange(cellRange[0], cellRange[1]);
    }

    private String extractSingleCell(String formula) {
        String cellRef = formula.substring(formula.indexOf("(") + 1, formula.indexOf(")"));
        return cellRepository.findByCellReference(cellRef).getContent();
    }
}
