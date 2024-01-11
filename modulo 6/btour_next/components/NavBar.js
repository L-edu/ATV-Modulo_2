import Link from 'next/link';
import styles from '../styles/Navbar.module.css';

const Navbar = () => {
  return (
    <nav className={styles.navbar}>
      <Link href="/">Home</Link>
      <Link href="/usuario">Usuario</Link>
      <Link href="/reserva">Reserva</Link>
      <Link href="/pacote">Pacote</Link>
    </nav>
  );
};

export default Navbar;
