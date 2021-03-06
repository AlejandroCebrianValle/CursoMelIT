import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'coche',
        loadChildren: () => import('./coche/coche.module').then(m => m.MycarsCocheModule)
      },
      {
        path: 'propietario',
        loadChildren: () => import('./propietario/propietario.module').then(m => m.MycarsPropietarioModule)
      },
      {
        path: 'incidente',
        loadChildren: () => import('./incidente/incidente.module').then(m => m.MycarsIncidenteModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class MycarsEntityModule {}
