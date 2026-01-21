<template>
  <div>
    <h1>Products</h1>

    <p v-if="loading">Loading products...</p>
    <p v-if="error" class="error">{{ error }}</p>

    <ul v-if="!loading">
      <li v-for="p in products" :key="p.id">
        {{ p.name }} – {{ p.pricePerDay }} PLN / day
        <button @click="remove(p.id)">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { fetchProducts, deleteProduct } from '@/api/productsApi';

const products = ref([]);
const loading = ref(true);
const error = ref(null);

async function load() {
  try {
    products.value = await fetchProducts();
  } catch (e) {
    error.value = e.message;
  } finally {
    loading.value = false;
  }
}

async function remove(id) {
  await deleteProduct(id);
  products.value = products.value.filter(p => p.id !== id);
}

onMounted(load);
</script>

<style scoped>
.error {
  color: red;
}
</style>
