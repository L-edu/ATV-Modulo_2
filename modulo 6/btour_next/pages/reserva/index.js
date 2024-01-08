import "bootstrap/dist/css/bootstrap.css";
import { useEffect, useState } from "react";
import axios from "axios";
import style from "../../styles/Home.module.css";
import Link from "next/link";

// Função para obter o nome com base no usuarioId
function obterNomePorUsuarioId(usuarioId, reservas) {
  const reserva = reservas.find(reserva => reserva.usuarioId === usuarioId);
  return reserva && reserva.usuario ? reserva.usuario.nome : 'Usuário não encontrado';
}

// Função para obter o destino com base no pacoteId
function obterDestinoPorPacoteId(pacoteId, reservas) {
  const reserva = reservas.find(reserva => reserva.pacoteId === pacoteId);
  return reserva && reserva.pacote ? reserva.pacote.destino : 'Destino não encontrado';
}

const Home = () => {
  const [reservas, setReservas] = useState([]);

  useEffect(() => {
    axios
      .get("https://localhost:7271/api/Reservas")
      .then((response) => {
        setReservas(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar a lista de reservas:", error);
      });
  }, []);

  return (
    <div>
      <h1 className={style.h1}>Lista de Reservas</h1>
      <p>
        <Link href="reserva/add-reserva" style={{ backgroundColor: "green", color: 'white', textDecoration: 'none' }}>
          Inserir Reserva
        </Link>
      </p>
      <table className="table container tabela">
        <thead>
          <tr>
            <th>ReservaId</th>
            <th>Usuario</th>
            <th>Pacote</th>
            <th>Data de Ida</th>
            <th>Data de Volta</th>
            <th>Quantidade</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {reservas.map((element) => (
            <tr key={element.id} className={style.tabela}>
              <td>{element.reservaId}</td>
              <td>{obterNomePorUsuarioId(element.usuarioId, reservas)}</td>
              <td>{obterDestinoPorPacoteId(element.pacoteId, reservas)}</td>
              <td>{element.dataInicio}</td>
              <td>{element.dataFim}</td>
              <td>{element.qtdPessoa}</td>
              <td>
                <Link
                  href={`reserva/update-reserva/${element.reservaId}`}
                  className="btn btn-warning"
                >
                  Editar
                </Link>
                <Link
                  href={`reserva/delete-reserva/${element.reservaId}`}
                  className="btn btn-danger"
                >
                  Excluir
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default Home;
