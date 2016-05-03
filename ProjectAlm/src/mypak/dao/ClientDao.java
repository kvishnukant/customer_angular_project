package mypak.dao;

import java.util.List;

import mypak.entities.ClientData;
import mypak.entities.User;

public interface ClientDao {

	boolean addClient(ClientData newClient);
	boolean deleteClient(int removeClient);
	boolean updateClient(ClientData updateClient);
	List<ClientData> getClient(int id);
	List<ClientData> showClients();
}
