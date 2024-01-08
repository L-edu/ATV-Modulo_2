import "bootstrap/dist/css/bootstrap.css";
import { useEffect, useState } from "react";
import axios from "axios";
import style from "../../styles/Home.module.css";
import Link from "next/link"; // Importe o Link para criar links de navegação

const Home = () => {
  const [pacotes, setPacotes] = useState([]);

  useEffect(() => {
    // Faça uma chamada GET para a API Spring Boot
    axios
      .get("https://localhost:7271/api/Pacotes")
      .then((response) => {
        setPacotes(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de pacotes:", error);
      });
  }, []);

  return (
    <div>
      <h1 className={style.h1}>Lista de Pacotes</h1>
      <p>
        <Link href="pacote/add-pacote" style={{ backgroundColor: "green" , color:'white', textDecoration:'none'}}>
          Inserir Pacote
        </Link>
      </p>
      <table className="table container tabela">
        <thead>
          <tr>
            <th>PacoteId</th>
            <th>Destino</th>
            <th>Preço</th>
            <th>Ações</th>{" "}
            {/* Adicione uma coluna para as ações de edição e exclusão */}
          </tr>
        </thead>
        {pacotes.map((element) => (
          <tbody key={element.id}>
            <tr className={style.tabela}>
              <td>{element.pacoteId}</td>
              <td>{element.destino}</td>
              <td>{element.preco}</td>
              <td>
                <Link
                  href={`pacote/update-pacote/${element.pacoteId}`}
                  className="btn btn-warning"
                >
                  Editar
                </Link>
                <Link
                  href={`pacote/delete-pacote/${element.pacoteId}`}
                  className="btn btn btn-danger"
                >
                  Excluir
                </Link>
              </td>
            </tr>
          </tbody>
        ))}
      </table>
    </div>
  );
};

export default Home;
