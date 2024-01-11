import React, { useEffect } from 'react';
import { Button } from 'react-bootstrap';
import backgroundImage from '../components/imgs/bgviagem.jpg'; // Substitua pelo caminho real da sua imagem
import styles from '../styles/Index.module.css';


const MenuCrud = () => {
  useEffect(() => {
    import('bootstrap/dist/js/bootstrap').then((bootstrap) => {
      const { Tooltip, Toast, Popover } = bootstrap;
      [Tooltip, Toast, Popover].forEach((ctor) => {
        new ctor(document.body);
      });
    });
  }, []);

  return (
    <div className='{styles.body}'
      style={{
        textAlign: 'center',
        marginTop: '100px',
        backgroundImage: `url(${backgroundImage})`,
        backgroundSize: 'cover', 
        backgroundPosition: 'center',
        color: 'white',
        padding: '50px',
        height: '500px', 
      }}
    >
      <h1 style={{ fontSize: '3rem', marginBottom: '30px' }}>Bem-vindo ao Bahia Tour</h1>
      <h1 style={{ fontSize: '1.2rem', marginBottom: '50px' }}>Explore as maravilhas da Bahia conosco!</h1>
    </div>
  );
};

export default MenuCrud;
