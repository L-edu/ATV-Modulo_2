using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Btour_API.Models
{
    [Table("Usuarios")]
    public class Usuario
    {
        [Key]
        public int UsuarioId { get; set; }

        [Required]
        [StringLength(80)]
        public string? Nome { get; set; }

        [Required]
        [StringLength(80)]
        public string? Email { get; set; }

        [Required]
        [StringLength(80)]
        public string? Senha { get; set; }

        [Required]
        [StringLength(80)]
        public string? Telefone { get; set; }
        [JsonIgnore]
        public List<Reserva>? Reservas { get; set; }
    }
}
