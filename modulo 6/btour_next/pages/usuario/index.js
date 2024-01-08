import "bootstrap/dist/css/bootstrap.css";
import { useEffect, useState } from "react";
import axios from "axios";
import style from "../../styles/Home.module.css";
import Link from "next/link"; // Importe o Link para criar links de navegação

const Home = () => {
  const [usuarios, setUsuarios] = useState([]);

  useEffect(() => {
    // Faça uma chamada GET para a API Spring Boot
    axios
      .get("https://localhost:7271/api/Usuarios")
      .then((response) => {
        setUsuarios(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de clientes:", error);
      });
  }, []);

  return (
    <div>
      <h1 className={style.h1}>Lista de Usuarios</h1>
      <p>
        <Link href="usuario/add-usuario" style={{ backgroundColor: "green" , color:'white', textDecoration:'none'}}>
          Inserir Usuario
        </Link>
      </p>
      <table className="table container tabela">
        <thead>
          <tr>
            <th>UsuarioId</th>
            <th>Nome</th>
            <th>Email</th>
            <th>Telefone</th>
            <th>Ações</th>{" "}
            {/* Adicione uma coluna para as ações de edição e exclusão */}
          </tr>
        </thead>
        {usuarios.map((element) => (
          <tbody key={element.id}>
            <tr className={style.tabela}>
              <td>{element.usuarioId}</td>
              <td>{element.nome}</td>
              <td>{element.email}</td>
              <td>{element.telefone}</td>
              <td>
                <Link
                  href={`usuario/update-usuario/${element.usuarioId}`}
                  className="btn btn-warning"
                >
                  Editar
                </Link>
                <Link
                  href={`usuario/delete-usuario/${element.usuarioId}`}
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
