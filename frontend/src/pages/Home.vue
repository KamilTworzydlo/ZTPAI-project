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
    error.value = "Nie udało się pobrać oferty.";
  } finally {
    loading.value = false;
  }
});
</script>

<template>
  <!-- HERO -->
  <section class="hero">
    <h1>Wynajem szalunków i rusztowań</h1>
    <p>
      Profesjonalna wypożyczalnia szalunków ściennych, stropowych oraz rusztowań
      budowlanych. Obsługujemy klientów indywidualnych i firmy.
    </p>
  </section>

  <!-- ABOUT -->
  <section class="about">
    <h2>Kim jesteśmy?</h2>
    <p>
      Tworzydło to lokalna wypożyczalnia sprzętu budowlanego, specjalizująca się
      w wynajmie systemów szalunkowych oraz rusztowań. Stawiamy na jakość,
      terminowość i przejrzyste warunki współpracy.
    </p>
  </section>

  <!-- PRODUCTS -->
  <section class="products">
    <h2>Nasza oferta</h2>

    <p v-if="loading">Ładowanie oferty...</p>
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
.hero {
  background: linear-gradient(135deg, #1f2933, #111827);
  color: #fff;
  padding: 4rem 2rem;
  text-align: center;
}

.hero h1 {
  font-size: 2.3rem;
  margin-bottom: 1rem;
}

.hero p {
  max-width: 720px;
  margin: 0 auto;
  color: #e5e7eb;
}

.about {
  max-width: 900px;
  margin: 4rem auto;
  padding: 0 2rem;
  text-align: center;
}

.about h2 {
  margin-bottom: 1rem;
}

.about p {
  color: #4b5563;
  line-height: 1.6;
}

.products {
  padding: 2rem;
}

.products h2 {
  text-align: center;
  margin-bottom: 2rem;
}

.grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 2rem;
}
</style>
