package mail;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Mail extends Remote {

    // Cadastrar usuário
    boolean registerUser(User user) throws RemoteException;

    // Recupera a primeira mensagem na lista de mensagens do usuario; a mensagem deve ser removida
    // Exigir autenticação do usuário
    Message getMessage (String username, String password) throws RemoteException;

    // retorna o número de mensagens na fila de mensagens dos usuário
    // Exigir autenticação do usuário
    int getMessagesNumber (String username, String password) throws RemoteException;

    // Exigir autenticação do usuário (senha do remetente, incluído como atributo da mensagem)
    boolean sendMessage (Message message, String password, String usernameDestiny) throws RemoteException;
}