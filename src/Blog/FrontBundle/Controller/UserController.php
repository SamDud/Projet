<?php

namespace Blog\FrontBundle\Controller;

use Blog\FrontBundle\Entity\User;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class UserController extends Controller
{

    public function listAction()
    {
        $em = $this->getDoctrine()->getManager();
        $rep = $em->getRepository(User::class);
        $users = $rep->findBy([], ['lastname' => 'ASC']);

        return $this->render('@BlogFront/User/list.html.twig', array('users' => $users));
    }

    public function viewAction(User $user)
    {
        return $this->render('@BlogFront/User/view.html.twig', array('user' => $user));
    }
}
