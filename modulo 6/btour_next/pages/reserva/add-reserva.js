import { useState, useEffect } from "react";
import axios from "axios";
import style from "../../styles/Home.module.css";
import { useRouter } from "next/router";

const AddReserva = () => {
  const [newReserva, setNewReserva] = useState({
    dataInicio: "",
    dataFim: "",
    usuarioId: "", // Alterado para um campo de seleção
    pacoteId: "", // Alterado para um campo de seleção
    qtdPessoa: "",
  });
  const [usuarios, setUsuarios] = useState([]);
  const [pacotes, setPacotes] = useState([]);
  const router = useRouter();

  useEffect(() => {
    // Carregar lista de usuários e pacotes ao carregar a página
    axios
      .get("https://localhost:7271/api/Usuarios")
      .then((response) => setUsuarios(response.data))
      .catch((error) => console.error("Erro ao buscar usuários:", error));

    axios
      .get("https://localhost:7271/api/Pacotes")
      .then((response) => setPacotes(response.data))
      .catch((error) => console.error("Erro ao buscar pacotes:", error));
  }, []);

  const handleInputChange = (e) => {
    setNewReserva({ ...newReserva, [e.target.name]: e.target.value });
  };

  const handleAddReserva = () => {
    axios
      .post("https://localhost:7271/api/Reservas", newReserva)
      .then(() => {
        router.push("/reserva");
      })
      .catch((error) => {
        alert("Erro ao inserir reserva:" + error);
      });
  };

  return (
    <div style={{ margin: "0 auto" }}>
      <h1 className={style.h1}>Inserir Reserva</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>Usuario:</label>
            </td>
            <td>
              <select
                name="usuarioId"
                value={newReserva.usuarioId}
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
                value={newReserva.pacoteId}
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
                value={newReserva.dataInicio}
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
                value={newReserva.dataFim}
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
                value={newReserva.qtdPessoa}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleAddReserva}>Inserir Reserva</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default AddReserva;
