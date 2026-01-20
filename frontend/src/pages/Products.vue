<script setup>
import { ref, onMounted } from "vue";
import { fetchProducts } from "../api/products";
import ProductCard from "../components/ProductCard.vue";




const products = ref([]);
const loading = ref(true);
const error = ref(null);

onMounted(async () => {
  try {
    products.value = await fetchProducts();
  } catch (e) {
    error.value = "Nie udało się pobrać produktów.";
  } finally {
    loading.value = false;
  }
});
</script>

<template>
  <section>
    <h1>Produkty</h1>
    <p class="intro">
      Oferujemy szeroki wybór szalunków i rusztowań do zastosowań budowlanych.
    </p>

    <p v-if="loading">Ładowanie...</p>
    <p v-else-if="error">{{ error }}</p>

    <div v-else class="grid">
      <ProductCard
        v-for="product in products"
        :key="product.id"
        :product="product"
      />
    </div>
  </section>
</template>

<style scoped>
h1 {
  margin-bottom: 0.5rem;
}

.intro {
  margin-bottom: 2rem;
  color: #4b5563;
}

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 2rem;
}
</style>
