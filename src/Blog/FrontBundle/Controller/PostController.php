<?php

namespace Blog\FrontBundle\Controller;

use Blog\FrontBundle\Entity\Comment;
use Blog\FrontBundle\Entity\Post;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\Form\Extension\Core\Type\SubmitType;
use Symfony\Component\Form\Extension\Core\Type\TextareaType;
use Symfony\Component\Form\Extension\Core\Type\TextType;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;


class PostController extends Controller
{

    public function viewAction($id)
    {

        if($id <= 0){
            throw $this->createNotFoundException('Article introuvable : '. $id);
        }

        $em = $this->getDoctrine()->getManager();
        $rep = $em->getRepository(Post::class);
        $post = $rep->find($id);

        return $this->render('@BlogFront/Post/post.html.twig',
            ['post' => $post]);
    }

    
    public function postViewAction($idpost, Request $request)
    {
        $comment= new Comment();
        
        $form = $this->createFormBuilder($comment)
               
                ->add('description' , TextareaType::class)
                ->add('post', TextType::class)
                ->add('valider', SubmitType::class)
                ->getForm();
        
        $form->handleRequest($request);
        
        if($form->isSubmitted()&& $form->isValid())
        {
            
            return new Response('Formulaire valide');
        }
            
        return $this->render('@BlogFront/Post/view.post.html.twig', array(
            'form' =>$form->createView(),
            'titre' => 'Test du formulaire'));
            

}
}
