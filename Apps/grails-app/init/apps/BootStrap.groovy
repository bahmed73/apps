package apps

class BootStrap {

    def init = { servletContext ->
    
				/*def adminRole = new Role(authority: 'ROLE_ADMIN').save()
		
				 def testUser = new User(username: 'foodal', password: 'homecookme').save()
		
				 UserRole.create testUser, adminRole
		
				 UserRole.withSession {
					it.flush()
					it.clear()
				 }*/
		
				 /*assert User.count() == 1
				 assert Role.count() == 1
				 assert UserRole.count() == 1*/
		}
    def destroy = {
    }
}
