using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Btour_API.Context;
using Btour_API.Models;

namespace Btour_API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PacotesController : ControllerBase
    {
        private readonly DataContext _context;

        public PacotesController(DataContext context)
        {
            _context = context;
        }

        // GET: api/Pacotes
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Pacote>>> GetPacotes()
        {
          if (_context.Pacotes == null)
          {
              return NotFound();
          }
            return await _context.Pacotes.ToListAsync();
        }

        // GET: api/Pacotes/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Pacote>> GetPacote(int id)
        {
          if (_context.Pacotes == null)
          {
              return NotFound();
          }
            var pacote = await _context.Pacotes.FindAsync(id);

            if (pacote == null)
            {
                return NotFound();
            }

            return pacote;
        }

        // PUT: api/Pacotes/5
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPut("{id}")]
        public async Task<IActionResult> PutPacote(int id, Pacote pacote)
        {
            if (id != pacote.PacoteId)
            {
                return BadRequest();
            }

            _context.Entry(pacote).State = EntityState.Modified;

            try
            {
                await _context.SaveChangesAsync();
            }
            catch (DbUpdateConcurrencyException)
            {
                if (!PacoteExists(id))
                {
                    return NotFound();
                }
                else
                {
                    throw;
                }
            }

            return NoContent();
        }

        // POST: api/Pacotes
        // To protect from overposting attacks, see https://go.microsoft.com/fwlink/?linkid=2123754
        [HttpPost]
        public async Task<ActionResult<Pacote>> PostPacote(Pacote pacote)
        {
          if (_context.Pacotes == null)
          {
              return Problem("Entity set 'DataContext.Pacotes'  is null.");
          }
            _context.Pacotes.Add(pacote);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetPacote", new { id = pacote.PacoteId }, pacote);
        }

        // DELETE: api/Pacotes/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeletePacote(int id)
        {
            if (_context.Pacotes == null)
            {
                return NotFound();
            }
            var pacote = await _context.Pacotes.FindAsync(id);
            if (pacote == null)
            {
                return NotFound();
            }

            _context.Pacotes.Remove(pacote);
            await _context.SaveChangesAsync();

            return NoContent();
        }

        private bool PacoteExists(int id)
        {
            return (_context.Pacotes?.Any(e => e.PacoteId == id)).GetValueOrDefault();
        }
    }
}
