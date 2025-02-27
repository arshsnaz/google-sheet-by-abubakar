import React, { useState, useEffect } from "react";
import axios from "axios";
import "./Spreadsheet.css";

const Spreadsheet = () => {
  const [cells, setCells] = useState({});
  const [formula, setFormula] = useState("");
  const [darkMode, setDarkMode] = useState(false);
  const [columns, setColumns] = useState(10);
  const [rows, setRows] = useState(10);
  const sheetName = "Sheet1";

  useEffect(() => {
    fetchCells();
  }, []);

  const fetchCells = async () => {
    try {
      const response = await axios.get(`http://localhost:8080/api/cells/${sheetName}`);
      const cellData = {};
      response.data.forEach((cell) => {
        cellData[`${cell.rowIndex}-${cell.colIndex}`] = cell.content;
      });
      setCells(cellData);
    } catch (error) {
      console.error("Error fetching cells:", error);
    }
  };

  const handleCellChange = (row, col, value) => {
    const newCells = { ...cells, [`${row}-${col}`]: value };
    setCells(newCells);
    saveCell(row, col, value);
  };

  const saveCell = async (row, col, content) => {
    try {
      await axios.post("http://localhost:8080/api/cells", {
        rowIndex: row,
        colIndex: col,
        content,
        sheetName,
      });
    } catch (error) {
      console.error("Error saving cell:", error);
    }
  };

  const applyFormula = () => {
    try {
      if (formula.startsWith("=SUM(")) {
        const range = formula.match(/\(([^)]+)\)/)[1];
        const [start, end] = range.split(":");
        const [startRow, startCol] = parseCell(start);
        const [endRow, endCol] = parseCell(end);

        let sum = 0;
        for (let i = startRow; i <= endRow; i++) {
          for (let j = startCol; j <= endCol; j++) {
            sum += Number(cells[`${i}-${j}`]) || 0;
          }
        }
        setFormula(`SUM = ${sum}`);
      }
    } catch (error) {
      alert("Invalid Formula!");
    }
  };

  const parseCell = (cell) => {
    const row = parseInt(cell.slice(1), 10) - 1;
    const col = cell.charCodeAt(0) - 65;
    return [row, col];
  };

  const applyTextFunction = (type) => {
    const updatedCells = { ...cells };
    Object.keys(updatedCells).forEach((key) => {
      if (type === "UPPER") updatedCells[key] = updatedCells[key].toUpperCase();
      if (type === "LOWER") updatedCells[key] = updatedCells[key].toLowerCase();
      if (type === "TRIM") updatedCells[key] = updatedCells[key].trim();
    });
    setCells(updatedCells);
  };

  const addRow = () => {
    setRows(rows + 1);
  };

  const addColumn = () => {
    setColumns(columns + 1);
  };

  const toggleDarkMode = () => {
    setDarkMode(!darkMode);
  };

  return (
    <div className={`spreadsheet-container ${darkMode ? "dark-mode" : ""}`}>
      <h2>Google Sheets Clone</h2>
      <div className="toolbar">
        <input
          type="text"
          placeholder="Enter formula (e.g. =SUM(A1:A3))"
          value={formula}
          onChange={(e) => setFormula(e.target.value)}
        />
        <button onClick={applyFormula}>Enter</button>
        <button className="dark-mode-toggle" onClick={toggleDarkMode}>
          {darkMode ? "Light Mode" : "Dark Mode"}
        </button>
        <button onClick={addRow}>Add Row</button>
        <button onClick={addColumn}>Add Column</button>
        <button onClick={() => applyTextFunction("UPPER")}>UPPER</button>
        <button onClick={() => applyTextFunction("LOWER")}>LOWER</button>
        <button onClick={() => applyTextFunction("TRIM")}>TRIM</button>
      </div>
      <table className="spreadsheet-table">
        <tbody>
          {Array.from({ length: rows }).map((_, row) => (
            <tr key={row}>
              {Array.from({ length: columns }).map((_, col) => (
                <td key={`${row}-${col}`} className="spreadsheet-cell">
                  <input
                    type="text"
                    className="cell-input"
                    value={cells[`${row}-${col}`] || ""}
                    onChange={(e) => handleCellChange(row, col, e.target.value)}
                  />
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Spreadsheet;
