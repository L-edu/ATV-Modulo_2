import Link from 'next/link';
import styles from '../styles/Footer.module.css';

const Footer = () => {
  return (
    <footer className={styles.footer}>
      <div className="container">
        <div className="row">
          <div className="col-md-6">
            <div>
              <p>
                <strong>Projeto Bahia Tour | Recode</strong>
              </p>
              <p>
                Desenvolvido por <strong>Eduardo Reis</strong>
              </p>
            </div>
          </div>
          <div className="col-md-6">
            <div className="social-links">
              <Link className="btn btn-outline-light btn-sm mx-1" href="https://github.com/L-edu" target="_blank">
                GitHub
              </Link>
              <Link className="btn btn-outline-light btn-sm mx-1" href="https://www.linkedin.com/in/eduardo-reis-developer/" target="_blank">
                LinkedIn
              </Link>
            </div>
          </div>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
