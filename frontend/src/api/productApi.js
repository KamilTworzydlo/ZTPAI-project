const BASE_URL = 'http://localhost:8080/api/products';

export async function getProducts() {
  const res = await fetch(BASE_URL);
  if (!res.ok) return [];
  return res.json();
}

export async function getProduct(id) {
  const res = await fetch(`${BASE_URL}/${id}`);
  return res.json();
}

export async function createProduct(product) {
  const res = await fetch(BASE_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(product),
  });
  return res.json();
}

export async function updateProduct(id, product) {
  const res = await fetch(`${BASE_URL}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(product),
  });
  return res.json();
}

export async function deleteProduct(id) {
  return fetch(`${BASE_URL}/${id}`, { method: 'DELETE' });
}
