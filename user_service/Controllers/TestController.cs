using user_service.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;
using System;
using System.Collections.Generic;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authorization;

namespace user_service.Controllers
{
    [Route("[controller]")]
    [Authorize]

    [ApiController]
    public class TestController : ControllerBase
    {

        [HttpGet]
        [Route("GetData")]
        [Authorize(Roles="User")]
        public IActionResult GetData()
        {
            return Ok(new { message = "You are Authorized!" });
        }
    }
}