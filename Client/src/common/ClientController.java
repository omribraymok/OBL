package common;

import controller.BorrowBookController;
import controller.LoginController;
import entity.User;

public class ClientController {
	
	
	
	/**
	 * message send back to the client (from the server) and has analyze
	 * what sort of message has been returned
	 * @param msg
	 */
	public static void messageAnalyze(Object msg) 
	{
		{
			MessageCS message = (MessageCS)msg;
			switch(message.messageType) {
			case LOGIN:
				//go to main menu of subscriber
				if(message.getUser().getRole() == User.Role.SUBSCRIBER)
				{
					LoginController.userRole = User.Role.SUBSCRIBER;
				}
				//go to main menu of librarian
				else if(message.getUser().getRole() == User.Role.LIBRARIAN)
				{
					LoginController.userRole = User.Role.LIBRARIAN;
				}
				//go to main menu of manager
				else if(message.getUser().getRole() == User.Role.LIBRARIAN) 
				{
					LoginController.userRole = User.Role.MANAGER;
				}
				break;
			case SEARCH_SUBSCRIBER:
				BorrowBookController.resultSubscriber = message.getSubscriber();
				break;
			case SEARCH_BOOK_FOR_BORROW:
				BorrowBookController.resultBook = message.getBook();
			case BORROW:
				BorrowBookController.resultBorrowedBook = message.getBorrowedBook();
			case BORROW1:
				BorrowBookController.cancel_borrow=message.getBook();
				break;
			default:
				break;
				
			}	
		}
		
	}
}
