using Btour_API.Models;
using Microsoft.EntityFrameworkCore;

namespace Btour_API.Context
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions <DataContext> options) : base(options) { }
        public DbSet<Usuario>? Usuarios { get; set; }
        public DbSet<Pacote>? Pacotes { get; set; }
        public DbSet<Reserva>? Reserva { get; set; }
    }
}
