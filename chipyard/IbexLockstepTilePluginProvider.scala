package chipyard.config

import ibexLockstep.IbexLockstepTileAttachParams
import freechips.rocketchip.subsystem.HierarchicalElementPortParamsLike

class IbexLockstepTilePluginProvider extends TilePluginProvider {
  // Ibex tile params do not define generic trace toggles in Chipyard; no-op for trace injectors.

  override def tilePrefetchInjectors(make: (Int, HierarchicalElementPortParamsLike) => HierarchicalElementPortParamsLike) = Seq({
    case tp: IbexLockstepTileAttachParams => tp.copy(crossingParams = tp.crossingParams.copy(
      master = make(tp.tileParams.tileId, tp.crossingParams.master)))
  })
}

