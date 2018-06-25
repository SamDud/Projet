<?php

namespace Blog\FrontBundle\Controller;

use Blog\FrontBundle\Entity\Post;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {

        $em = $this->getDoctrine()->getManager();
        $rep = $em->getRepository(Post::class);
        $posts = $rep->getLastPosts($this->getParameter('nombre_post_index'));

        $args = array('posts' => $posts);
        return $this->render('@BlogFront/Default/index.html.twig', $args);
    }

    public function aboutAction()
    {
        return $this->render('@BlogFront/Default/about.html.twig');
    }
}
