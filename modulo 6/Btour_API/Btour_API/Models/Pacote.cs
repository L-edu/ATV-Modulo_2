using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace Btour_API.Models
{
    [Table("Pacotes")]
    public class Pacote
    {
        [Key]
        public int PacoteId { get; set; }

        [Required]
        [StringLength(80)]
        public string? Destino { get; set; }

        [Required]
        [Column(TypeName = "decimal(10,2)")]
        public decimal Preco { get; set; }
        [JsonIgnore]
        public List<Reserva>? Reservas { get; set; }
    }
}
