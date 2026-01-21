<template>
  <div class="layout">
    <!-- HEADER -->
    <header class="header">
      <div class="logo">
        WYPOŻYCZALNIA SZALUNKÓW <strong>TWORZYDŁO</strong>
      </div>

      <nav class="nav">
        <router-link to="/" class="nav-link">
          Strona główna
        </router-link>

        <router-link to="/products" class="nav-link">
          Produkty
        </router-link>

        <router-link to="/calculator" class="nav-link">
          Kalkulator wynajmu
        </router-link>

        <router-link to="/login" class="nav-link">
          Logowanie
        </router-link>

        <a href="tel:+48600123456" class="btn btn-primary">
          Zadzwoń teraz
        </a>

        <a
          href="https://www.facebook.com/profile.php?id=100064062483832"
          target="_blank"
          rel="noopener"
          class="btn btn-secondary"
        >
          Facebook
        </a>
      </nav>
    </header>

    <!-- CONTENT -->
    <main class="content">
      <router-view />
    </main>

    <!-- FOOTER -->
    <footer class="footer">
      <p>© 2026 Tworzydło – Wynajem szalunków i rusztowań</p>
    </footer>
  </div>
</template>

<script setup>
// App.vue pełni wyłącznie rolę layoutu
// Logika jest w komponentach widoków (router-view)
</script>

<style>
/* =====================
   RESET
===================== */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
}

/* =====================
   PAGE LAYOUT
===================== */
.layout {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

/* =====================
   HEADER
===================== */
.header {
  position: sticky;
  top: 0;
  z-index: 100;
  background: #1f2933;
  color: #ffffff;
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-size: 1.05rem;
  letter-spacing: 0.5px;
  white-space: nowrap;
}

/* =====================
   NAVIGATION
===================== */
.nav {
  display: flex;
  align-items: center;
  gap: 1rem;
  flex-wrap: wrap;
  justify-content: flex-end;
}

.nav-link {
  color: #e5e7eb;
  text-decoration: none;
  font-size: 0.95rem;
}

.nav-link:hover {
  text-decoration: underline;
}

/* ACTIVE ROUTE */
.router-link-active {
  font-weight: bold;
  text-decoration: underline;
}

/* =====================
   BUTTONS
===================== */
.btn {
  padding: 0.45rem 0.8rem;
  border-radius: 4px;
  font-size: 0.9rem;
  text-decoration: none;
  font-weight: bold;
  white-space: nowrap;
}

.btn-primary {
  background: #f59e0b;
  color: #000000;
}

.btn-primary:hover {
  background: #d97706;
}

.btn-secondary {
  background: #1877f2;
  color: #ffffff;
}

.btn-secondary:hover {
  background: #0f5dc2;
}

/* =====================
   CONTENT
===================== */
.content {
  flex: 1;
  padding: 2rem;
}

/* =====================
   FOOTER
===================== */
.footer {
  background: #111827;
  color: #9ca3af;
  text-align: center;
  padding: 1rem;
  font-size: 0.85rem;
}

/* =====================
   RESPONSIVE
===================== */
@media (max-width: 900px) {
  .header {
    flex-direction: column;
    align-items: flex-start;
    gap: 0.75rem;
  }

  .nav {
    width: 100%;
    justify-content: flex-start;
  }
}

@media (max-width: 600px) {
  .nav {
    gap: 0.5rem;
  }

  .btn {
    font-size: 0.85rem;
    padding: 0.4rem 0.6rem;
  }
}
</style>
