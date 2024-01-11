import { useState, useEffect } from "react";
import axios from "axios";
import style from "../../../styles/Update.module.css";
import { useRouter } from 'next/router';


const UpdateClient = () => {
  const [usuario, setUsuario] = useState({ usuarioId: "",  nome: "", email: "" , telefone: "", senha: "" });
  const router = useRouter(); 
  const { codigo } = router.query;

  useEffect(() => {
    // Faça uma chamada GET para a API para obter detalhes do cliente a ser atualizado
    axios
      .get("https://localhost:7271/api/Usuarios/" + usuario.usuarioId)
      .then((response) => {
       setUsuario(response.data);      
      })
      .catch((error) => {
        console.error("Erro ao buscar detalhes do usuario:", error);
      });
  }, [usuario.usuarioId]);

  const handleInputChange = (e) => {
    setUsuario({ ...usuario, [e.target.name]: e.target.value });
  };

  const handleUpdateClient = () => {
    axios
      .put("https://localhost:7271/api/Usuarios/" + usuario.usuarioId, usuario)
      .then(() => {
        router.push('/usuario');    
   
      })
      .catch((error) => {
        console.error("Erro ao atualizar usuario:", error);
      });
  };

  return (
    
    <div>
      <h1 className={style.h1}>Atualizar Usuario</h1>
      <table style={{marginLeft:'20px'}}>
        <tbody>
          <tr>
            <td>
              <label>ID do Usuario:</label>
            </td>
            <td>
              <input
                type="text"
                name="id"
                value={usuario.usuarioId = codigo}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Nome:</label>
            </td>
            <td>
              <input
                type="text"
                name="nome"
                value={usuario.nome}
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
                value={usuario.email}
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
                value={usuario.telefone}
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
                value={usuario.senha}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleUpdateClient}>Atualizar Usuario</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default UpdateClient;
