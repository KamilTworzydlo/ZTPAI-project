<template>
  <div>
    <!-- HEADER -->
    <header class="header">
      <div class="logo">
        WYPOŻYCZALNIA SZALUNKÓW <strong>TWORZYDŁO</strong>
      </div>

      <nav class="nav">
        <a href="#" class="nav-link">Strona główna</a>
        <a href="#" class="nav-link">Produkty</a>
        <a href="#" class="nav-link">Kalkulator wynajmu</a>
        <a href="#" class="nav-link">Logowanie</a>

        <a
          href="tel:+48600123456"
          class="btn btn-primary"
        >
          Zadzwoń teraz
        </a>

        <a
          href="https://www.facebook.com/profile.php?id=100064062483832"
          target="_blank"
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

<style>
/* RESET */
* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  font-family: Arial, Helvetica, sans-serif;
}

/* HEADER */
.header {
  position: sticky;
  top: 0;
  z-index: 100;
  background: #1f2933;
  color: #fff;
  padding: 1rem 2rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  font-size: 1.1rem;
  letter-spacing: 0.5px;
}

.nav {
  display: flex;
  align-items: center;
  gap: 1rem;
}

.nav-link {
  color: #e5e7eb;
  text-decoration: none;
  font-size: 0.95rem;
}

.nav-link:hover {
  text-decoration: underline;
}

/* BUTTONS */
.btn {
  padding: 0.45rem 0.8rem;
  border-radius: 4px;
  font-size: 0.9rem;
  text-decoration: none;
  font-weight: bold;
}

.btn-primary {
  background: #f59e0b;
  color: #000;
}

.btn-primary:hover {
  background: #d97706;
}

.btn-secondary {
  background: #1877f2;
  color: #fff;
}

.btn-secondary:hover {
  background: #0f5dc2;
}

/* CONTENT */
.content {
  padding: 2rem;
  min-height: calc(100vh - 140px);
}

/* FOOTER */
.footer {
  background: #111827;
  color: #9ca3af;
  text-align: center;
  padding: 1rem;
  font-size: 0.85rem;
}

/* RESPONSIVE */
@media (max-width: 900px) {
  .nav {
    flex-wrap: wrap;
    justify-content: flex-end;
  }
}
</style>
