import { useState, useEffect } from "react";
import axios from "axios";
import style from "../../../styles/Home.module.css";
import { useRouter } from "next/router";

const UpdateReserva = () => {
  const [reserva, setReserva] = useState({
    reservaId: "",
    dataInicio: "",
    dataFim: "",
    usuarioId: "",
    pacoteId: "",
    qtdPessoa: "",
  });
  const [usuarios, setUsuarios] = useState([]);
  const [pacotes, setPacotes] = useState([]);
  const router = useRouter();
  const { codigo } = router.query;

  useEffect(() => {
    // Faça uma chamada GET para a API para obter detalhes da reserva a ser atualizada
    axios
      .get("https://localhost:7271/api/Reservas/" + codigo)
      .then((response) => {
        setReserva(response.data);
      })
      .catch((error) => {
        console.error("Erro ao buscar detalhes da reserva:", error);
      });

    // Faça chamadas GET para a API para obter a lista de usuários e pacotes
    axios
      .get("https://localhost:7271/api/Usuarios")
      .then((response) => setUsuarios(response.data))
      .catch((error) => console.error("Erro ao buscar usuários:", error));

    axios
      .get("https://localhost:7271/api/Pacotes")
      .then((response) => setPacotes(response.data))
      .catch((error) => console.error("Erro ao buscar pacotes:", error));
  }, [codigo]);

  const handleInputChange = (e) => {
    setReserva({ ...reserva, [e.target.name]: e.target.value });
  };

  const handleUpdateReserva = () => {
    axios
      .put("https://localhost:7271/api/Reservas/" + codigo, reserva)
      .then(() => {
        router.push("/reserva");
      })
      .catch((error) => {
        console.error("Erro ao atualizar reserva:", error);
      });
  };

  return (
    <div>
      <h1 className={style.h1}>Atualizar Reserva</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>ID da Reserva:</label>
            </td>
            <td>
              <input
                type="text"
                name="reservaId"
                value={reserva.reservaId}
                readOnly
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Usuario:</label>
            </td>
            <td>
              <select
                name="usuarioId"
                value={reserva.usuarioId}
                onChange={handleInputChange}
              >
                <option value="">Selecione um usuário</option>
                {usuarios.map((usuario) => (
                  <option key={usuario.usuarioId} value={usuario.usuarioId}>
                    {usuario.nome}
                  </option>
                ))}
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <label>Pacote:</label>
            </td>
            <td>
              <select
                name="pacoteId"
                value={reserva.pacoteId}
                onChange={handleInputChange}
              >
                <option value="">Selecione um pacote</option>
                {pacotes.map((pacote) => (
                  <option key={pacote.pacoteId} value={pacote.pacoteId}>
                    {pacote.destino}
                  </option>
                ))}
              </select>
            </td>
          </tr>
          <tr>
            <td>
              <label>Ida:</label>
            </td>
            <td>
              <input
                type="date"
                name="dataInicio"
                value={reserva.dataInicio}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Volta:</label>
            </td>
            <td>
              <input
                type="date"
                name="dataFim"
                value={reserva.dataFim}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Quantidade:</label>
            </td>
            <td>
              <input
                type="text"
                name="qtdPessoa"
                value={reserva.qtdPessoa}
                onChange={handleInputChange}
              />
            </td>
          </tr>

          <tr>
            <td colSpan="2">
              <button onClick={handleUpdateReserva}>Atualizar Reserva</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default UpdateReserva;
