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
    error.value = "Nie udało się pobrać oferty. Spróbuj ponownie później.";
  } finally {
    loading.value = false;
  }
});
</script>

<template>
  <section class="hero">
    <h1>Wynajem szalunków i rusztowań</h1>
    <p>
      Profesjonalny wynajem szalunków ściennych, stropowych oraz rusztowań
      budowlanych. Szybko, solidnie i w dobrej cenie.
    </p>

    <div class="hero-actions">
      <a href="tel:+48600123456" class="btn btn-primary">
        Zadzwoń teraz
      </a>
      <a
        href="https://www.facebook.com/profile.php?id=100064062483832"
        target="_blank"
        class="btn btn-secondary"
      >
        Facebook
      </a>
    </div>
  </section>

  <section class="products">
    <h2>Nasza oferta</h2>

    <p v-if="loading" class="status">Ładowanie oferty...</p>
    <p v-else-if="error" class="status error">{{ error }}</p>

    <div v-else class="products-grid">
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
  font-size: 2.4rem;
  margin-bottom: 1rem;
}

.hero p {
  max-width: 720px;
  margin: 0 auto 2rem;
  font-size: 1.05rem;
  line-height: 1.6;
  color: #e5e7eb;
}

.hero-actions {
  display: flex;
  justify-content: center;
  gap: 1rem;
  flex-wrap: wrap;
}

.products {
  margin-top: 4rem;
}

.products h2 {
  text-align: center;
  font-size: 1.8rem;
  margin-bottom: 2rem;
}

.products-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 2rem;
}

.status {
  text-align: center;
  font-weight: 500;
  margin-top: 2rem;
}

.status.error {
  color: #dc2626;
}

/* RESPONSIVE */
@media (max-width: 768px) {
  .hero h1 {
    font-size: 1.9rem;
  }
}
</style>
