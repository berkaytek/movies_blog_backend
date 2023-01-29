using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Identity.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore;
using user_service.Models;

public class UserServiceDbContext : IdentityDbContext<IdentityUser>
{
    public UserServiceDbContext(DbContextOptions<UserServiceDbContext> options) : base(options) { }
    public virtual DbSet<MovieUser> MovieUsers { get; set; }

}
