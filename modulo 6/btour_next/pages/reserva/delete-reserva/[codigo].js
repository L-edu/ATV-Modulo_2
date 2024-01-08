import { useState } from "react";
import axios from "axios";
import style from "../../../styles/Home.module.css";
import { useRouter } from "next/router";

const DeleteReserva = () => {
  const router = useRouter();
  const { codigo } = router.query;
  const [reservaId, setReserva] = useState(codigo);
 

  const handleDeleteReserva = () => {
  
    axios
      .delete("https://localhost:7271/api/Reservas/" + reservaId)
      .then(() => {
        router.push("/reserva");
      })
      .catch((error) => {
        alert("Erro ao excluir reserva:" + error);
      });
  };

  return (

    <div>
    
      <h1 className={style.h1}>Excluir Reserva</h1>
      <table style={{ marginLeft: "20px" }}>
        <tbody>
          <tr>
            <td>
              <label>ID Reserva:</label>
            </td>
            <td>
              <input
                type="text"
                value={reservaId}
                onChange={(e) => setReserva(e.target.value)}
              />
            </td>
          </tr>
          <tr>
            <td colSpan="2">
              <button onClick={handleDeleteReserva}>Excluir Reserva</button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
};

export default DeleteReserva;
