import { useState, useEffect } from "react";
import axios from "axios";
import style from "../../../styles/Update.module.css";
import { useRouter } from 'next/router';


const UpdatePacote = () => {
  const [pacote, setPacote] = useState({ pacoteId: "",  destino: "", preco: "" });
  const router = useRouter(); 
  const { codigo } = router.query;

  useEffect(() => {
    // Faça uma chamada GET para a API para obter detalhes do cliente a ser atualizado
    axios
      .get("https://localhost:7271/api/Pacotes/" + pacote.pacoteId)
      .then((response) => {
       setPacote(response.data);      
      })
      .catch((error) => {
        console.error("Erro ao buscar detalhes do pacote:", error);
      });
  }, [pacote.pacoteId]);

  const handleInputChange = (e) => {
    setPacote({ ...pacote, [e.target.name]: e.target.value });
  };

  const handleUpdatePacote = () => {
    axios
      .put("https://localhost:7271/api/Pacotes/" + pacote.pacoteId, pacote)
      .then(() => {
        router.push('/pacote');    
   
      })
      .catch((error) => {
        console.error("Erro ao atualizar pacote:", error);
      });
  };

  return (
    
    <div>
      <h1 className={style.h1}>Atualizar Pacote</h1>
      <table style={{marginLeft:'20px'}}>
        <tbody>
          <tr>
            <td>
              <label>ID do Pacote:</label>
            </td>
            <td>
              <input
                type="text"
                name="id"
                value={pacote.pacoteId = codigo}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Destino:</label>
            </td>
            <td>
              <input
                type="text"
                name="destino"
                value={pacote.destino}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td>
              <label>Preço:</label>
            </td>
            <td>
              <input
                type="text"
                name="preco"
                value={pacote.preco}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          
          <tr>
            <td colSpan="2">
              <button onClick={handleUpdatePacote}>Atualizar Pacote</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default UpdatePacote;
