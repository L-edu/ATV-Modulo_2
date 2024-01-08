import { useState } from "react";
import axios from "axios";
import style from "../../styles/Home.module.css";
import { useRouter } from "next/router";

const AddPacote= () => {



  const [newPacote, setNewPacote] = useState({ destino: "", preco: ""});
  const router = useRouter();

  const handleInputChange = (e) => {
    setNewPacote({ ...newPacote, [e.target.name]: e.target.value });
  };

  const handleAddPacote = () => {
    axios
      .post("https://localhost:7271/api/Pacotes", newPacote)
      .then(() => {
        router.push("/pacote");
      })
      .catch((error) => {
        alert("Erro ao inserir pacote:" + error);
      });
  };

  return (  
    <div style={{ margin: "0 auto" }}>
      <h1 className={style.h1}>Inserir Pacote</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>Destino:</label>
            </td>
            <td>
              <input
                type="text"
                name="destino"
                value={newPacote.destino}
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
                value={newPacote.preco}
                onChange={handleInputChange}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleAddPacote}>Inserir Pacote</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default AddPacote;
