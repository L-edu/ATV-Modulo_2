using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Btour_API.Models
{
    [Table("Reservas")]
    public class Reserva
    {
        [Key]
        public int ReservaId { get; set; }
        public DateTime DataInicio { get; set; }
        public DateTime DataFim { get; set; }
        public int  QtdPessoa { get; set; }
        public Usuario? Usuario { get; set; }
        public int UsuarioId { get; set; }
        public Pacote? Pacote { get; set; }
        public int PacoteId { get; set; }
    }
}
