<template>
  <div>
    <h2>Produkty</h2>

    <p v-if="loading">Ładowanie produktów...</p>
    <p v-if="error" class="error">{{ error }}</p>

    <ul v-if="products.length">
      <li v-for="product in products" :key="product.id">
        <strong>{{ product.name }}</strong> –
        {{ product.pricePerDay }} zł / dzień
        <br />
        <small>{{ product.categoryName }}</small>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { onMounted, ref } from 'vue';
import { fetchProducts } from '../services/productService';

const products = ref([]);
const loading = ref(true);
const error = ref(null);

onMounted(async () => {
  try {
    products.value = await fetchProducts();
  } catch (e) {
    error.value = 'Nie udało się pobrać produktów';
  } finally {
    loading.value = false;
  }
});
</script>

<style scoped>
.error {
  color: red;
}
</style>
