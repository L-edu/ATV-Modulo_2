import { useState } from "react";
import axios from "axios";
import style from "../../styles/Update.module.css";
import { useRouter } from "next/router";

const AddClient = () => {



  const [newUsuario, setNewUsuario] = useState({ nome: "", email: "" , telefone: "", senha: ""});
  const router = useRouter();

  const handleInputChange = (e) => {
    setNewUsuario({ ...newUsuario, [e.target.name]: e.target.value });
  };

  const handleAddClient = () => {
    axios
      .post("https://localhost:7271/api/Usuarios", newUsuario)
      .then(() => {
        router.push("/usuario");
      })
      .catch((error) => {
        alert("Erro ao inserir usuario:" + error);
      });
  };

  return (  
    <div style={{ margin: "0 auto" }}>
      <h1 className={style.h1}>Inserir Usuario</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>Nome:</label>
            </td>
            <td>
              <input
                type="text"
                name="nome"
                value={newUsuario.nome}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Email:</label>
            </td>
            <td>
              <input
                type="text"
                name="email"
                value={newUsuario.email}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Telefone:</label>
            </td>
            <td>
              <input
                type="text"
                name="telefone"
                value={newUsuario.telefone}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Senha:</label>
            </td>
            <td>
              <input
                type="password"
                name="senha"
                value={newUsuario.senha}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleAddClient}>Inserir Usuario</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default AddClient;
