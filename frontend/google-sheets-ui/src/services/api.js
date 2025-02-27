import axios from "axios";

const API_BASE_URL = "http://localhost:9090/api/cells"; // Change to 9090 if needed

export const getCellsBySheet = async (sheetName) => {
  return axios.get(`${API_BASE_URL}/${sheetName}`);
};

export const saveCell = async (cellData) => {
  return axios.post(API_BASE_URL, cellData);
};

export const deleteCell = async (id) => {
  return axios.delete(`${API_BASE_URL}/${id}`);
};
