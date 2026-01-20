import axios from 'axios'

const API_BASE = import.meta.env.VITE_API_BASE || 'http://localhost:8080'

export async function fetchProducts() {
  try {
    const res = await axios.get(`${API_BASE}/api/products`)
    return res.data
  } catch (error) {
    console.error('API error:', error)
    throw error
  }
}

export async function fetchProductById(id) {
  const res = await axios.get(`${API_BASE}/api/products/${id}`)
  return res.data
}
