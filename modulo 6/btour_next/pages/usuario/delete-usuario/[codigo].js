import { useState } from "react";
import axios from "axios";
import style from "../../../styles/Home.module.css";
import { useRouter } from "next/router";

const DeleteClient = () => {
  const router = useRouter();
  const { codigo } = router.query;
  const [usuarioId, setUsuario] = useState(codigo);
 

  const handleDeleteClient = () => {
  
    axios
      .delete("https://localhost:7271/api/Usuarios/" + usuarioId)
      .then(() => {
        router.push("/usuario");
      })
      .catch((error) => {
        alert("Erro ao excluir usuario:" + error);
      });
  };

  return (

    <div>
    
      <h1 className={style.h1}>Excluir Usuario</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>ID Usuario:</label>
            </td>
            <td>
              <input
                type="text"
                value={usuarioId}
                onChange={(e) => setUsuario(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleDeleteClient}>Excluir Usuario</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default DeleteClient;
